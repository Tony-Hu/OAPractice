package twilio;

import org.junit.Test;

import static org.junit.Assert.*;

public class HostsTest {

  @Test
  public void processFile() {
    Hosts hosts = new Hosts();
    hosts.processFile("hosts_access_log_00.txt");
  }
}