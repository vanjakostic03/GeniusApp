package Serialization;

import java.io.*;

import Models.Data.AccountsList;
import Models.Data.ArtistList;
import Models.Data.PublishedWorkList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Serialization {

    private XStream xstream;

    public Serialization() {
        xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(AccountsList.class);
        xstream.processAnnotations(ArtistList.class);
        xstream.processAnnotations(PublishedWorkList.class);
    }

    public void save() throws IOException {
        File accountsFile = new File("./Data/accounts.xml");
        OutputStream osAccounts = new BufferedOutputStream(new FileOutputStream(accountsFile));
        try {
            xstream.toXML(AccountsList.getInstance(), osAccounts);

        } finally {
            osAccounts.close();

        }
    }

    public void load() throws IOException {
       File accountsFile = new File("./Data/accounts.xml");
        InputStream isAccounts = new BufferedInputStream(new FileInputStream(accountsFile));
       AccountsList accountsList = null;
        try {
            accountsList = ((AccountsList) xstream.fromXML(isAccounts));
        } finally {
            isAccounts.close();

        }
        AccountsList.setInstance(accountsList);
    }

    public XStream getXStream() {
        return xstream;
    }

}