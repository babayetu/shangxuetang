package squirrel.demo;

import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.TransitionPriority;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

public class MvelDemo {
	//1.定义状态机事件
		enum FSMEvent {
			ToA, ToB, ToC, ToD
		}
		
		//2.1定义Context Object
		public class MyContext {
			private int value;

			public int getValue() {
				return value;
			}

			public void setValue(int value) {
				this.value = value;
			}

			public String toString() {
				return "MyContext [value=" + value + "]";
			}
			
		}
				
		//2.定义状态机类
		@StateMachineParameters(stateType=String.class,eventType=FSMEvent.class,contextType=MyContext.class)
		static class StateMachineSample extends AbstractUntypedStateMachine {
			protected void fromAToB(String from, String to, FSMEvent event, MyContext context) {
				System.out.println("Transition from '"+from+"' to '"+to+"' on event '"+event+
		                "' with context '"+context+"'.");
			}
			
			protected void ontoB(String from, String to, FSMEvent event, MyContext context) {
	            System.out.println("Entry State \'"+to+"\'.");
	        }
			
			private void action1() {
				System.out.println("action1()");
			}
			
			private void action2() {
				System.out.println("action2()");
			}
		}
		
		
		
		public static void main(String[] args) {
			//3.建立状态转换
			UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(StateMachineSample.class);
			builder.externalTransition().from("A").to("B").on(FSMEvent.ToB).whenMvel(
				    "MyCondition:::(context!=null && context.getValue()>5)").callMethod("fromAToB");
			builder.onEntry("B").callMethod("ontoB");

			
			// 4. 开动状态机
	        UntypedStateMachine fsm = builder.newStateMachine("A");
	        MvelDemo md = new MvelDemo();
	        MyContext mc = md.new MyContext();
	        mc.setValue(4);
	        fsm.fire(FSMEvent.ToB,mc);

	        System.out.println("Current state is "+fsm.getCurrentState());
		}

}
