public interface Assessment {
    public String type();
    public void display();
    public void close();
    public void submit();
    public String get_status();
    public String sub_status();
    public float getmarks();
}
