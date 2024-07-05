package Models;


import Enums.TypeOfArtist;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("artist")
public abstract class Artist {

    protected String id;
    protected RecordLabel recordLabel;
    protected TypeOfArtist typeOfArtist;

    public Artist(String id, RecordLabel recordLabel, TypeOfArtist typeOfArtist) {
        this.id = id;
        this.recordLabel = recordLabel;
        this.typeOfArtist = typeOfArtist;

    }

    public RecordLabel getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(RecordLabel recordLabel) {
        this.recordLabel = recordLabel;
    }

    public TypeOfArtist getTypeOfArtist() {
        return typeOfArtist;
    }

    public void setTypeOfArtist(TypeOfArtist typeOfArtist) {
        this.typeOfArtist = typeOfArtist;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

