package cn.mldn.microboot.producer;

import cn.mldn.microboot.vo.Dept;

public interface IMessageProducerService {
	public void sendMessage(String msg) ;
	public void sendMessage(Dept dept) ;
}
