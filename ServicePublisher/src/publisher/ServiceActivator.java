package publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator{
	@SuppressWarnings("rawtypes")
	ServiceRegistration serviceReg;
	
	@Override
	public void start(BundleContext context) throws Exception {
		WeatherGenI tg = WeatherGenImpl.getInstance();
		serviceReg = context.registerService(WeatherGenI.class.getName(), tg, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		serviceReg.unregister();
	}

}
