package comt.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 第一种方法就是直接实现Interceptor接口，这样的话，就要实现这个接口中的三个方法。
	 * 
	 * 第二种方法是继承自AbstractInterceptor类，这是个抽象类，实现了Interceptor接口，并且对里面的init()
	 * 和destroy
	 * ()方法进行空实现，而把intercept()方法设置为抽象方法，让继承它的子类去实现，这样的话，子类只要实现这个intercept
	 * ()方法就可以了，比直接实现接口要简单一些。
	 * 
	 * 第三种方法是继承自MethodFilterInterceptor，这个类叫做方法过滤拦截器，这个类继承自AbstractInterceptor，
	 * 并且提供了一种机制
	 * ，即可以指定对Action中某些方法进行拦截或者是不拦截，所谓拦截不拦截，指的就是拦截器中的intercept()方法是否被执行了
	 * ，若没有执行，就是没有拦截，若执行了，就是拦截了。
	 * 
	 */
	private static final long serialVersionUID = -4409507846064552966L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept
	 * (com.opensymphony.xwork2.ActionInvocation)
	 */

	@Override
	public String intercept(ActionInvocation invoker) throws Exception {
		// TODO Auto-generated method stub
		String actionName = invoker.getProxy().getActionName();
		if ("adLogin".equals(actionName)) {
			return invoker.invoke();

		}
		//adminInfo adminInfo = (comt.model.adminInfo) ActionContext.getContext().getSession().get("admin");
		Object user=ActionContext.getContext().getSession().get("adminphone");
		if (null == user) {
			return Action.ERROR; // 这里返回用户登录页面视图
		}
		return invoker.invoke();
	}
}
