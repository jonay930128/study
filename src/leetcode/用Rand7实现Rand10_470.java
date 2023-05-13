package leetcode;

/**
 * @author ruxing.wrx
 * @date 2023/5/9 10:13
 */
public class 用Rand7实现Rand10_470 {
    /**
     * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
     * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
     * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
     *
     */
    public int rand10() {
        /*
            1、rand7() 范围：1~7
            2、rand7()-1 范围：0~6
            3、(rand7()-1)*7 范围：0,7,14,21,28,35,42
            4、(rand7()-1)*7 + rand7()-1 范围：0~48
            5、判断第4步的值，去除大于等于40的值
            6、mod 10+1 返回
         */
        int temp = 40;
        while (temp >= 40) {
//            temp = (rand7()-1)*7 + rand7()-1;
        }
        return temp % 10 + 1;
    }
}
