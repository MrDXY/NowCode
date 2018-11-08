package class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}

	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>(); //一个存放数据，一个用来辅助
			help = new LinkedList<Integer>();
		}

		public void push(int pushInt) {
			queue.add(pushInt);
		} //把数据添加到data队列中

		public int peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				//队列中只留下最后一个元素，因为是先入先出，所以可以保留最后一个。
				help.add(queue.poll());
				//data在出队的同时，将输出的所有元素在help中入队。
			}
			int res = queue.poll(); //最后peek的结果就是“栈顶”的元素
			help.add(res); //peek不会真的弹出栈顶，所以还需要添加回来help队列中
			swap(); //将help变为queue，queue变为help
			return res;
		}

		public int pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() > 1) {
				//队列中只留下最后一个元素，因为是先入先出，所以可以保留最后一个。
				help.add(queue.poll());
				//data在出队的同时，将输出的所有元素在help中入队。
			}
			int res = queue.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}

	}
	public static void main(String args[]){

	}
}
