package servicesubscriber;

import model.Info;
import publisher.WeatherGenI;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import userInterfaces.UserInterface;
import userInterfaces.UserInterfaceImpl;

public class ServiceActivator implements BundleActivator {

	//Creates instance of UserInterfaceImpl() to run the gui
	UserInterface gui = new UserInterfaceImpl();
	
	private static BundleContext context;
	
	@SuppressWarnings("rawtypes")
	ServiceReference serviceReferenceProd1;
	@SuppressWarnings("rawtypes")
	ServiceReference serviceReferenceProd2;
	
	//Info class instances temporarily holds weather information
	Info producerInfo1 = new Info();
	Info producerInfo2 = new Info();
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		
		ServiceActivator.context = bundleContext;
		System.out.println("Start subscriber service");

		/*
		 * Gets information from producer
		 * */
		serviceReferenceProd1 = context.getServiceReference(WeatherGenI.class.getName());
		@SuppressWarnings("unchecked")
		WeatherGenI servicePublishProd1 = (WeatherGenI) context.getService(serviceReferenceProd1);
		
		producerInfo1.setTemperature(servicePublishProd1.tempGen("Colombo"));		
		producerInfo1.setWeather(servicePublishProd1.assumeWeather(producerInfo1.getTemperature()));

		
		/*
		 * Gets information from producer
		 * */
		serviceReferenceProd2 = context.getServiceReference(WeatherGenI.class.getName());
		@SuppressWarnings("unchecked")
		WeatherGenI servicePublishProd2 = (WeatherGenI) context.getService(serviceReferenceProd2);
		
		producerInfo2.setTemperature(servicePublishProd2.tempGen("Jaffna"));		
		producerInfo2.setWeather(servicePublishProd2.assumeWeather(producerInfo2.getTemperature()));	
		
		//Passes producer information from ServiceActivator class to UserInterface class
		gui.createHomeUI(producerInfo1, producerInfo2);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ServiceActivator.context = null;
		
		gui.closeGUI();
		System.out.println("Stop Subscriber Service");
		
		context.ungetService(serviceReferenceProd1);
		context.ungetService(serviceReferenceProd2);
	}

}
