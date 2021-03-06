package javaContest.Contest1;

/*
*	牛客网公司真题 练习
*	@author  zaichiyikoua
*	@time  2020年1月30日
*/

public class Topic5 {
    // 在Linux系统中，某文件权限的分数是754，则以下说法错误的是()
    // A.拥有者的权限是可读、可写、可执行
    // B.同用户组的权限是可写可执行
    // C.其他用户权限只有可读
    // D.所有用户对该文件都可读

    // 答案B
    // 754对应3种用户的权限：文件所有者、同组用户、其他用户
//    权限    权限数值       具体作用
//    r    4        read，读取。当前用户可以读取文件内容，当前用户可以浏览目录。
//    w    2        write，写入。当前用户可以新增或修改文件内容，当前用户可以删除、移动目录或目录内文件。
//    x    1        execute，执行。当前用户可以执行文件，当前用户可以进入目录。
    // 因此 7=4+2+1 文件所有者对该文件的的权限为可读可写可执行（A正确）
    // 5=4+1 同组用户对该文件的权限为可读可执行；4=4所其他用户对该文件的权限为可读（C正确）
    // 综上所有用户都有读权限（D正确）
}
