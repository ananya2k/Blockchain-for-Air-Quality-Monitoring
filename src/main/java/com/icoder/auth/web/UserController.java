package com.icoder.auth.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icoder.auth.model.AirData;
import com.icoder.auth.model.GraphData;
import com.icoder.auth.model.GraphData.KeyValue;
import com.icoder.auth.model.User;
import com.icoder.auth.service.AirDataService;
import com.icoder.auth.service.BlockChainService;
import com.icoder.auth.service.SecurityService;
import com.icoder.auth.service.UserService;
import com.icoder.auth.validator.AirDataValidator;
import com.icoder.auth.validator.UserValidator;
import com.icoder.common.block.Block;
import com.icoder.common.block.BlockChain;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
	@Autowired
    private UserService userService;
    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private AirDataService airDataService;
    
    @Autowired
    private AirDataValidator airDataValidator;
    
    @Autowired
    private BlockChainService blockChainService;
    
//    @Autowired
//    private GraphData graphData;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    @GetMapping("/add_block")
    public ModelAndView add_block() {
    	ModelAndView model=new ModelAndView();
    	if(userService.isAdmin(getPrincipal())){
    	List<String> PollutantList=new ArrayList<>();
    	PollutantList.add("Ozone");
    	PollutantList.add("Nitrogen Oxides");
    	PollutantList.add("Nitrogen Oxide");
    	PollutantList.add("Nitrogen Dioxide");
    	PollutantList.add("Fine Particulate Matter");
    	
    	model.setViewName("add_block");
    	model.addObject("airDataForm", new AirData());
    	model.addObject("PollutantList",PollutantList);
    	}else{
    		model.setViewName("Unauthorized");
    	}
    	return model;
    }
    @PostMapping("/add_block")
    public String add_block(Model model,@ModelAttribute("airDataForm") AirData airDataForm, BindingResult bindingResult) {
    	if(userService.isAdmin(getPrincipal())){
    		airDataValidator.validate(airDataForm, bindingResult);
        	
            if (bindingResult.hasErrors()) {
            	List<String> PollutantList=new ArrayList<>();
            	PollutantList.add("Ozone");
            	PollutantList.add("Nitrogen Oxides");
            	PollutantList.add("Nitrogen Oxide");
            	PollutantList.add("Nitrogen Dioxide");
            	PollutantList.add("Fine Particulate Matter");
            	
            	//model.addAttribute("airDataForm", new AirData());
            	model.addAttribute("PollutantList",PollutantList);
                return "add_block";
            }
            
            AirData airData=airDataService.save(airDataForm);
            BlockChain blockChain=new BlockChain();
            blockChain.addBlock(airData);
            
            return "redirect:/reports";
    	}else{
    		return "Unauthorized";
    	}
    }
    
    @GetMapping(value = "/graph")
    public ModelAndView getGraphData(@RequestParam(value = "date", required = false, defaultValue = "2017-01-01") String date) {
    	ModelAndView model=new ModelAndView();
    	AirData airData=new AirData();
    	airData.setDate(date);
    	model.setViewName("graph");
    	model.addObject("airDataForm",airData);
    	System.out.print(date);
    	GraphData.PieData(date);
    	List<KeyValue> pieDataList = GraphData.getPiechartData();
    	System.out.print(pieDataList);
    	model.addObject("pieDataList", pieDataList);
    	return model;
    }
    @GetMapping("/reports")
    public String reports(Model model, @PageableDefault(value=50, page=0) Pageable pageable) {
    	
    	Page<AirData> pages = airDataService.findAll(pageable);
    	model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
        model.addAttribute("size", pages.getSize());
        model.addAttribute("airDataList", pages.getContent());
        return "reports";
    }
    
    @GetMapping("/blockChainreports")
    public String blockChainReports(Model model, @PageableDefault(value=50, page=0) Pageable pageable) {
    	
    	BlockChain blockChain=new BlockChain();
    	List<AirData> airDataList=blockChain.getDataFromChain();
    	
    	PagedListHolder<AirData> page = new PagedListHolder<>(airDataList);
    	page.setPageSize(pageable.getPageSize()); // number of items per page
    	page.setPage(pageable.getPageNumber());      // set to first page
    	
    	model.addAttribute("totalPages",page.getPageCount());
    	model.addAttribute("size", page.getPageSize());
    	model.addAttribute("airDataList",page.getPageList());
    	
        return "blockChainreports";
    }
    
    @GetMapping("/validate_block_chain")
    public String validate_block_chain() {
    	return "validate_block_chain";
    }
    
    @PostMapping("/validate_block_chain")
    public ModelAndView validate_block_chain_post() {
    	BlockChain blockChain=new BlockChain();
    	boolean verify=BlockChain.verifyBlockChain();
    	System.out.println("Verified results:- ");
    	System.out.println(verify);
    	
    	ModelAndView model=new ModelAndView();
    	model.setViewName("validate_block_chain");
    	model.addObject("verify",verify);
    	model.addObject("MerkleRoot",Block.getMerkleRoot());
    	return model;
    }
    
    @GetMapping("/show_block_chain")
    public String show_block_chain(Model model, @PageableDefault(value=50, page=0) Pageable pageable) {
    	BlockChain blockChain=new BlockChain();
    	List<Block> blockChainList=blockChain.getChain();
    	blockChainList.forEach(val->{
    		System.out.println(val.toString());
    		});
    	
    	PagedListHolder<Block> page = new PagedListHolder<>(blockChainList);
    	page.setPageSize(pageable.getPageSize()); // number of items per page
    	page.setPage(pageable.getPageNumber());      // set to first page
    	
    	model.addAttribute("totalPages",page.getPageCount());
    	model.addAttribute("size", page.getPageSize());
    	model.addAttribute("blockChainList",blockChainList);
    	return "show_block_chain";
    }
    
    @GetMapping("/update_db_block_chain")
    public String update_db_block_chain() {
    	BlockChain blockChain=new BlockChain();
    	List<Block> blockChainList=blockChain.getChain();
    	blockChainService.deleteAll();
    	blockChainList.forEach(val->{
    		System.out.println(val.toString());
    		com.icoder.auth.model.BlockChain blockChainModel=new com.icoder.auth.model.BlockChain();
    		blockChainModel.setIndex(Long.valueOf(val.getIndex()));
    		blockChainModel.setTime_stamp((Long.valueOf(val.getTimeStamp())));
    		blockChainModel.setHash(val.getHash());
    		blockChainModel.setPrevious_hash(val.getPreviousHash());
    		blockChainService.save(blockChainModel);
    		});
    	return "show_block_chain";
    }
    
    @GetMapping("/validate_db_block_chain")
    public String validate_db_block_chain() {
    	Block block=blockChainService.ValidateBlockChain();
    	
    	logger.info(String.valueOf(block.getIndex()));
    	
    	return "show_block_chain";
    }
    
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
