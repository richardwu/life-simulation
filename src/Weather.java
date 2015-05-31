
public class Weather
{
	protected final static String [] types = {"Rain", "Hail", "Snow", "Sunny"};
	protected final static int TYPE_RAIN = 0;
	protected final static int TYPE_HAIL = 1;
	protected final static int TYPE_SNOW = 2;
	protected final static int TYPE_SUNNY = 3;
	
	protected int duration, severity, type;
	
	public Weather (int duration, int type, int severity)
	{
		this.duration = duration;
		this.type = type;
		this.severity = severity;
	}
	
	public int getType ()
	{
		return type;
	}
}
