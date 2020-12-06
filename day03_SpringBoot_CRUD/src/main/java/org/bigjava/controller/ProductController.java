package org.bigjava.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.bigjava.bean.Product;
import org.bigjava.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: ProductController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-29 14:39
 * @Version v1.0
 */
@Controller
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    /**
     * 查询所有产品返回产品页面
     * @data: 2020-08-30-14:46
     * @method: getProduct
     * @params: [model]
     * @return: java.lang.String
     */
    @GetMapping(value="/products")
    public String  getProduct(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,Model model){
        PageHelper.startPage(pageNum, 5);
        List<Product> list = productService.selectByAll(null);
        PageInfo<Product> info = new PageInfo<>(list, 5);
        model.addAttribute("info", info);
        model.addAttribute("products", list);
        return "/product/list";
    }
    /**
     * 查询需要修改的产品信息，并回显在修改页面
     * @data: 2020-08-30-14:57
     * @method: toUpdatePage
     * @params: [id, model]
     * @return: java.lang.String
     */
    @GetMapping(value="/product/{id}")
    public String  toUpdatePage(@PathVariable("id")Integer id,Model model){
        Product product = productService.selectByPrimaryKey(id);
        model.addAttribute("product", product);
        return "product/update";
    }
    /**
     * 修改产品信息
     * @data: 2020-08-30-14:57
     * @method: xxx
     * @params: []
     * @return: java.lang.String
     */
    @PutMapping(value="/product")
    public String  update(Product product){
        System.out.println("product = " + product);
        productService.updateByPrimaryKeySelective(product);
        return "redirect:/products";
    }
    /**
     * 删除产品
     * @data: 2020-08-30-22:20
     * @method: delete
     * @params: [id]
     * @return: java.lang.String
     */
    @DeleteMapping(value="/product/{id}")
    public String  delete(@PathVariable("id")Integer id){
        productService.deleteByPrimaryKey(id);
        return "redirect:/products";
    }
    /**
     * 添加商品
     * @data: 2020-08-30-22:20
     * @method: add
     * @params: [product]
     * @return: java.lang.String
     */
    @PostMapping(value="/product")
    public String  add(Product product){
        productService.insertSelective(product);
        return "redirect:/products";
    }
}
