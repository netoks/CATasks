package task03;

public class DnsServer {
    private String ip1;
    private String ip2;

    public DnsServer(String ip1, String ip2) {
        this.ip1 = ip1;
        this.ip2 = ip2;
    }

    @Override
    public String toString() {
        return String.format("DnsServer{%s, %s}", this.ip1, this.ip2);
    }
}
