package squirrel.demo;

import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

import squirrel.demo.MvelDemo.FSMEvent;

public class ConventionOverConfiguration {
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
		protected void transitFromAToBOnToB(String from, String to, FSMEvent event, MyContext context) {
			System.out.println("Transition from '"+from+"' to '"+to+"' on event '"+event+
	                "' with context '"+context+"'.");
		}
		
		protected void onToB(String from, String to, FSMEvent event, MyContext context) {
            System.out.println("Entry State \'"+to+"\'.");
        }
	}
	
	
	
	public static void main(String[] args) {
		//3.建立状态转换
		UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(StateMachineSample.class);
		//省略callMethod，用Convention替代
		builder.externalTransition().from("A").to("B").on(FSMEvent.ToB);
		builder.onEntry("B");
		
		// 4. 开动状态机
        UntypedStateMachine fsm = builder.newStateMachine("A");
        ConventionOverConfiguration coc = new ConventionOverConfiguration();
        MyContext mc = coc.new MyContext();
        mc.setValue(4);

        fsm.fire(FSMEvent.ToB,mc);

        System.out.println("Current state is "+fsm.getCurrentState());
	}

}
