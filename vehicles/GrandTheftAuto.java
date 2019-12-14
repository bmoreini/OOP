package edu.vtc.cis2260.vehicles;

public class GrandTheftAuto {

	public static void main(String[] args) {
		GasCar prius = new GasCar(50,10);
		//System.out.println(prius);
		
		PlugInHybrid volt = new PlugInHybrid(30,10, 100);
		GasCar otherVolt = new PlugInHybrid(30,10,100); //  implemented as pluginHybrid. So accesses that version of method. 
		System.out.println("Range: "+volt.getRange());
		otherVolt.drive(50);
		System.out.println(otherVolt);
		
		//otherVolt.charge(); // interface is driven by type, not implementation, so can't access methods specific to plugin.
		
		prius.drive(90);
		//System.out.println(prius);

		volt.drive(50);
		System.out.println(volt);
		
		volt.drive(50);
		System.out.println(volt);
		
		volt.drive(50);
		System.out.println(volt);
		
		volt.charge();
		
		volt.drive(50);
		System.out.println(volt);
	}

}
