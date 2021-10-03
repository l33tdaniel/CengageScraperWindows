public class Main {
    public static void main(String[] args) throws Exception {
        String CengageLink = "https://nglsync.cengage.com/portal/Account/LogOn?ReturnUrl=%2fportal";
        CengageDriver Cengage = new CengageDriver(CengageLink);

    }
}

/*
For the windows version of this program, we're currently running 
chrome driver 94
*/
// don't forget to delete creds 