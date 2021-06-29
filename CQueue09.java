package JZOffer;

import java.util.Stack;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: CQueeue09
 * @Author: hp
 * @Date: 23/06/2021 11:04
 * @Version: 1.0
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 * 描述：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * -------------------------------------- 题目理解 -------------------------------------
 * 说实话，要想看懂和这个题目真难！
 *  ["CQueue","appendTail","deleteHead","deleteHead"]
 *  [[],[3],[],[]]
 *  以上两个，第一个是具体操作，第二个是需要的参数。
 *  CQueue：创建队列，此时不需要参数
 *  appendTail：队尾新增元素，需要参数3
 *  deleteHead: 删除对头元素，不需要参数
 *  [null,null,3,-1],这个是返回值
 *  CQueue: 创建队列，返回null
 *  appendTail: 队尾新增元素3，返回null
 *  deleteHead: 删除队头元素（3），返回3
 *  deleteHead: 删除队头元素（此时为null），返回-1
 */
public class CQueue09 {
    // 两个栈，一个出栈，一个入栈
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public CQueue09 () {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if(!stackOut.isEmpty()) {
            return stackOut.pop();
        } else {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.isEmpty() ? -1 : stackOut.pop();
        }
    }
}
