package Models.Data;

import Enums.TypeOfWork;
import Models.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PublishedWorkService {

    private ArrayList<PublishedWork> publishedWorks;
    
    public PublishedWorkService() {
        
        publishedWorks = new ArrayList<PublishedWork>();
        loadPublishedWorksFromXML();
    }

    public ArrayList<PublishedWork> getPublishedWorks() {
        return publishedWorks;
    }

    public void setPublishedWorks(ArrayList<PublishedWork> publishedWorks) {
        this.publishedWorks = publishedWorks;
    }


    public void addPublishedWork(PublishedWork publishedWork) {
        publishedWorks.add(publishedWork);
    }

    public void updatePublishedWork(PublishedWork publishedWork, PublishedWork updatedPublishedWork) {
        publishedWorks.set(publishedWorks.indexOf(publishedWork), updatedPublishedWork);
    }

    public void deletePublishedWork(PublishedWork publishedWork) {
        publishedWorks.remove(publishedWork);
    }

    public void deletePublishedWorkById(String publishedWorkId) {
        PublishedWork pw = getPublishedWorkById(publishedWorkId);
        deletePublishedWork(pw);
    }

    public  boolean idExists(String id) {
        for (PublishedWork publishedWork : publishedWorks) {
            if (publishedWork.getId().equals(id)) {
                return true;

            }
        }
        return false;
    }


    public PublishedWork getPublishedWorkById(String id) {
        for (PublishedWork publishedWork : publishedWorks) {
            if (publishedWork.getId().equals(id)) {
                return publishedWork;
            }
        }
        return null;
    }

    public ArrayList<PublishedWork> getAlbums(){
        ArrayList<PublishedWork> albums = new ArrayList<>();
        for(PublishedWork publishedWork : publishedWorks){
            if(publishedWork.getTypeOfWork() == TypeOfWork.ALBUM){
                albums.add(publishedWork);
            }
        }
        return albums;
    }

    public ArrayList<PublishedWork> getSongs(){
        ArrayList<PublishedWork> songs = new ArrayList<>();
        for(PublishedWork publishedWork : publishedWorks){
            if(publishedWork.getTypeOfWork() == TypeOfWork.SONG){
                songs.add(publishedWork);
            }
        }
        return songs;
    }


    public String getFreeID(){
        int maxId = 0;
        for (PublishedWork publishedWork : publishedWorks) {

            try {
                int id = Integer.parseInt(publishedWork.getId().substring(2));
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException e) {
                // Ignore invalid IDs
            }

        }
        return "PW" + String.format("%03d", maxId + 1);
    }

    public void loadPublishedWorksFromXML() {
        XStream xstream = new XStream();
        xstream.alias("publishedWork", PublishedWork.class);
        xstream.alias("album",Album.class);
        xstream.alias("song", Song.class);

        xstream.addPermission(AnyTypePermission.ANY);


        xstream.aliasType("singleArtist", SingleArtist.class);
        xstream.aliasType("bend", Bend.class);
        xstream.aliasType("album",Album.class);
        xstream.aliasType("song", Song.class);

        try(FileReader reader = new FileReader("./Data/publishedWorks.xml")){
            publishedWorks = (ArrayList<PublishedWork>) xstream.fromXML(reader);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void savePublishedWorksToXML() {
        XStream xstream = new XStream();
        xstream.alias("publishedWork", PublishedWork.class);
        xstream.alias("album",Album.class);
        xstream.alias("song", Song.class);

        xstream.addPermission(AnyTypePermission.ANY); // Dodavanje permisije

        xstream.aliasType("singleArtist", SingleArtist.class);
        xstream.aliasType("bend", Bend.class);
        xstream.aliasType("album",Album.class);
        xstream.aliasType("song", Song.class);


        try (FileWriter writer = new FileWriter("./Data/publishedWorks.xml")) {
            xstream.toXML(publishedWorks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
