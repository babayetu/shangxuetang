package squirrel.demo;

import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

public class QuickStartSample {
	//1.定义状态机事件
	enum FSMEvent {
		ToA, ToB, ToC, ToD
	}
	
	//2.定义状态机类
	@StateMachineParameters(stateType=String.class,eventType=FSMEvent.class,contextType=Integer.class)
	static class StateMachineSample extends AbstractUntypedStateMachine {
		protected void fromAToB(String from, String to, FSMEvent event, Integer context) {
			System.out.println("Transition from '"+from+"' to '"+to+"' on event '"+event+
	                "' with context '"+context+"'.");
		}
		
		protected void ontoB(String from, String to, FSMEvent event, Integer context) {
            System.out.println("Entry State \'"+to+"\'.");
        }
	}
	
	public static void main(String[] args) {
		//3.建立状态转换
		UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(StateMachineSample.class);
		builder.externalTransition().from("A").to("B").on(FSMEvent.ToB).callMethod("fromAToB");
		builder.onEntry("B").callMethod("ontoB");
		
		// 4. 开动状态机
        UntypedStateMachine fsm = builder.newStateMachine("A");
        fsm.fire(FSMEvent.ToB, 10);

        System.out.println("Current state is "+fsm.getCurrentState());
	}

}
