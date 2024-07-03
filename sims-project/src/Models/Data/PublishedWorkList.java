package Models.Data;

import Models.PublishedWork;

import java.util.ArrayList;

public class PublishedWorkList {

    private ArrayList<PublishedWork> publishedWorkList;
    public PublishedWorkList() {
        publishedWorkList = new ArrayList<PublishedWork>();
    }

    public ArrayList<PublishedWork> getPublishedWorks() {
        return publishedWorkList;
    }

    public void setPublishedWorks(ArrayList<PublishedWork> publishedWorks) {
        this.publishedWorkList = publishedWorks;
    }


    public void addPublishedWork(PublishedWork publishedWork) {
        publishedWorkList.add(publishedWork);
    }

    public void updatePublishedWork(PublishedWork publishedWork, PublishedWork updatedPublishedWork) {
        publishedWorkList.set(publishedWorkList.indexOf(publishedWork), updatedPublishedWork);
    }

    public void deletePublishedWork(PublishedWork publishedWork) {
        publishedWorkList.remove(publishedWork);
    }



    public PublishedWork getPublishedWorkById(String id) {
        for (PublishedWork publishedWork : publishedWorkList) {
            if (publishedWork.getId().equals(id)) {
                return publishedWork;
            }
        }
        return null;
    }




}
