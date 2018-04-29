package cn.xiuyu.web.controller.authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication/user")
public class UserController {

    // @Reference
    // private UserService userService;
    //
    // @RequestMapping("login")
    // public MVCResult login(@RequestBody UserModel user) {
    // return new MVCResult().result("true").message(JSON.toJSONString(user));
    // }
    //
    // @RequestMapping(value = "save", method = RequestMethod.POST)
    // public MVCResult save(@RequestBody UserModel user) {
    // try {
    // userService.save(user);
    // return MVCResult.getTrueResult();
    // } catch (Exception e) {
    // return MVCResult.getFalseResult(e.getMessage());
    // }
    // }
    //
    // @RequestMapping("show")
    // public UserModel show(Integer id) {
    // return userService.show(id);
    // }
    //
    // @RequestMapping("list")
    // public Page<UserModel> list(@RequestParam(name = "currPage", defaultValue
    // = "1") Integer currPage,
    // @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
    // return null;
    // // return userService.list(currPage - 1, pageSize);
    //
    // }
    //
    // /**
    // * test
    // *
    // * @return
    // */
    // @RequestMapping("test")
    // public MVCResult test() {
    // System.out.println(userService);
    // userService.test();
    // return new MVCResult().result("true");
    //
    // }
}
