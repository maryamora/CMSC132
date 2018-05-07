import java.lang.management.*;

public class TimeCalculator {


    public TimeCalculator() {
    }

    /** Get CPU time in nanoseconds. */
    public Double getCpuTime( ) {
            ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
            return bean.isCurrentThreadCpuTimeSupported( ) ?
                    bean.getCurrentThreadCpuTime( ) : 0D;
    }

    /** Get user time in nanoseconds. */
    public long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadUserTime( ) : 0L;
    }

    /** Get system time in nanoseconds. */
    public long getSystemTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                (bean.getCurrentThreadCpuTime() - bean.getCurrentThreadUserTime( )) : 0L;
    }
}
