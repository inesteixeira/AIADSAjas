package com.aiad;

import com.aiad.agents.AgencyAgent;
import com.aiad.agents.BrokerAgent;
import com.aiad.agents.ClientAgent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.StaleProxyException;

import sajas.core.Runtime;
import sajas.sim.repast3.Repast3Launcher;
import sajas.wrapper.ContainerController;

import uchicago.src.sim.engine.ActionGroup;
import uchicago.src.sim.engine.BasicAction;
import uchicago.src.sim.engine.ScheduleBase;
import uchicago.src.sim.engine.SimInit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executor;

public class MyLauncher extends Repast3Launcher {

	private ContainerController mainContainer;
	private ContainerController agentContainer;

	private BrokerAgent brokerAgent1;
	private BrokerAgent brokerAgent2;
	private BrokerAgent brokerAgent3;
	private BrokerAgent brokerAgent4;
	private BrokerAgent brokerAgent5;

	private AgencyAgent agencyAgent;


	private List<ClientParameters> clientParameters;
	
	@Override
	public String[] getInitParam() {
		return new String[0];
	}

	@Override
	public String getName() {
		return "SAJaS Project";
	}

	class Runner1 extends BasicAction {
		public void execute() {
			Random random = new Random();
			int index = random.nextInt(clientParameters.size());
			ClientParameters clientParameter = clientParameters.get(index);
			ClientAgent clientAgent = new ClientAgent(clientParameter.name,
					clientParameter.typeOfInsurance,
					clientParameter.first,
					clientParameter.second,
					clientParameter.third,
					clientParameter.isNegotiator,
					clientParameter.max,
					clientParameter.min);
			try {
				agentContainer.acceptNewAgent("client" + UUID.randomUUID().toString(), clientAgent).start();
				agencyAgent.callBehaviour();
				brokerAgent1.callBehaviours();
				//brokerAgent2.callBehaviours();
				//brokerAgent3.callBehaviours();
				//brokerAgent4.callBehaviours();

				//brokerAgent5.callBehaviours();
			} catch (StaleProxyException e) {
				e.printStackTrace();
			}
		}
	};

	@Override
	protected void launchJADE() {
		
		Runtime rt = Runtime.instance();
		Profile p1 = new ProfileImpl();
		mainContainer = rt.createMainContainer(p1);
		agentContainer = mainContainer;

		buildClientParameters();
		launchAgents();

		getSchedule().scheduleActionAtInterval(5000, new Runner1());
	}

	private void buildClientParameters() {
		clientParameters = new ArrayList<ClientParameters>();

		clientParameters.add(new ClientParameters("Ines",
				"Vehicle",
				"23",
				"Car",  // Car Truck or Moto
				"2001", // LICENSE PLATE YEAR
				"true", // Negotiates?
				"10",   // Minimum discount it asks for
				"20"));
		clientParameters.add(new ClientParameters("Hugo",
				"House",
				"27",
				"Apartment", // House Apartment or Farm building
				"Urban", // Urban or Rural
				"false",
				"10",
				"20"));
		clientParameters.add(new ClientParameters("Maria",
				"Health",
				"50",
				"High Risk", // High Medium or Low risk patient
				"true", // IF TRUE => OBESE ELSE => ANOREXIC
				"false",
				"10",
				"20"));
		clientParameters.add(new ClientParameters("Rita",
				"Vehicle",
				"55",
				"Moto",  // Car Truck or Moto
				"2015", // LICENSE PLATE YEAR
				"true", // Negotiates?
				"15",   // Minimum discount it asks for
				"35"));
		clientParameters.add(new ClientParameters("Jose",
				"House",
				"65",
				"Farm", // House Apartment or Farm building
				"Rural", // Urban or Rural
				"true",
				"15",
				"30"));
		clientParameters.add(new ClientParameters("Antonio",
				"Health",
				"50",
				"Low Risk", // High Medium or Low risk patient
				"false", // IF TRUE => OBESE ELSE => ANOREXIC
				"true",
				"8",
				"17"));
		clientParameters.add(new ClientParameters("Luisa",
				"Vehicle",
				"32",
				"Moto",  // Car Truck or Moto
				"2020", // LICENSE PLATE YEAR
				"false", // Negotiates?
				"1",   // Minimum discount it asks for
				"5"));
	}
	
	private void launchAgents() {
		
		try {

			/*ClientAgent clientAgent = new ClientAgent("Ines",
					"House",
					"23",
					"Apartment", // House Apartment or Farm building
					"Urban", // Urban or Rural
					"true",
					"10",
					"20");
			agentContainer.acceptNewAgent("client", clientAgent).start();*/


			brokerAgent1 = new BrokerAgent("Joao",
					"Vehicle|House", // Types of insurances
					"0.65",			 // Comission
					"false",          // Applies discount?
					"5");
			agentContainer.acceptNewAgent("broker1", brokerAgent1).start();
			brokerAgent2 = new BrokerAgent("Joana",
					"House|Health",
					"0.67",
					"true",
					"18");
			//agentContainer.acceptNewAgent("broker2", brokerAgent2).start();
			brokerAgent3 = new BrokerAgent("Rui",
					"Health|Vehicle",
					"0.78",
					"true",
					"15");
			//agentContainer.acceptNewAgent("broker3", brokerAgent3).start();

			brokerAgent4 = new BrokerAgent("Filipa",
					"Vehicle|House|Health",
					"0.63",
					"false",
					"5");
			//agentContainer.acceptNewAgent("broker4", brokerAgent4).start();

			/*brokerAgent5 = new BrokerAgent("Pedro",
					"Vehicle|House",
					"0.77",
					"true",
					"35");
			agentContainer.acceptNewAgent("broker5", brokerAgent5).start();*/

			agencyAgent = new AgencyAgent();
			agentContainer.acceptNewAgent("agency", agencyAgent).start();

		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
		
	}
/*
	@Override
	public void setup() {
		super.setup();

		// property descriptors
		// ...
	}

	@Override
	public void begin() {
		super.begin();
		
		// display surfaces, spaces, displays, plots, ...
		// ...
	}
*/
	/**
	 * Launching Repast3
	 * @param args
	 */
	public static void main(String[] args) {
		boolean BATCH_MODE = true;
		SimInit init = new SimInit();
		init.setNumRuns(2);   // works only in batch mode
		init.loadModel(new MyLauncher(), null, true);
	}

}
