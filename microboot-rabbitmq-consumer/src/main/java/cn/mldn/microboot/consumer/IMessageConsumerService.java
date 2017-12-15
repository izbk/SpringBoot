package cn.mldn.microboot.consumer;

import cn.mldn.microboot.vo.Dept;

public interface IMessageConsumerService {
	public void receiveMessage(String text);
	public void receiveMessage(Dept dept);
}
