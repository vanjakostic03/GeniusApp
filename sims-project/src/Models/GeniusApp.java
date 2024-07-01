package Models;

import java.util.ArrayList;

public class GeniusApp {
    private Account temporaryUser;
    private ArrayList<Account> accounts;
    private ArrayList<Genre> genres;
    private ArrayList<Artist> artists;
    private ArrayList<PublishedWork> publishedWorks;
    private ArrayList<PlayList> playlists;
    private ArrayList<ArtistVoting> artistVotings;
    private ArrayList<PublishedWorkVoting> publishedWorkVotings;
    private ArrayList<Comment> comments;
    private ArrayList<Review> reviews;
    private ArrayList<RecordLabel> recordLabels;
    private ArrayList<TopList> topLists;
    private ArrayList<Advertisment> advertisments;
    private ArrayList<Event> events;

    public GeniusApp() {
        temporaryUser = null;
        accounts = new ArrayList<>();
        genres = new ArrayList<>();
        artists = new ArrayList<>();
        publishedWorks = new ArrayList<>();
        playlists = new ArrayList<>();
        artistVotings = new ArrayList<>();
        publishedWorkVotings = new ArrayList<>();
        comments = new ArrayList<>();
        reviews = new ArrayList<>();
        recordLabels = new ArrayList<>();
        topLists = new ArrayList<>();
        advertisments = new ArrayList<>();
        events = new ArrayList<>();

    }

    public Account getTemporaryUser() {
        return temporaryUser;
    }

    public void setTemporaryUser(Account temporaryUser) {
        this.temporaryUser = temporaryUser;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArrayList<PublishedWork> getPublishedWorks() {
        return publishedWorks;
    }

    public void setPublishedWorks(ArrayList<PublishedWork> publishedWorks) {
        this.publishedWorks = publishedWorks;
    }

    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<ArtistVoting> getArtistVotings() {
        return artistVotings;
    }

    public void setArtistVotings(ArrayList<ArtistVoting> artistVotings) {
        this.artistVotings = artistVotings;
    }

    public ArrayList<PublishedWorkVoting> getPublishedWorkVotings() {
        return publishedWorkVotings;
    }

    public void setPublishedWorkVotings(ArrayList<PublishedWorkVoting> publishedWorkVotings) {
        this.publishedWorkVotings = publishedWorkVotings;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<RecordLabel> getRecordLabels() {
        return recordLabels;
    }

    public void setRecordLabels(ArrayList<RecordLabel> recordLabels) {
        this.recordLabels = recordLabels;
    }

    public ArrayList<TopList> getTopLists() {
        return topLists;
    }

    public void setTopLists(ArrayList<TopList> topLists) {
        this.topLists = topLists;
    }

    public ArrayList<Advertisment> getAdvertisments() {
        return advertisments;
    }

    public void setAdvertisments(ArrayList<Advertisment> advertisments) {
        this.advertisments = advertisments;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public void login(Account account){
        temporaryUser = account;
    }

    public void logout(){
        this.temporaryUser = null;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void updateAccount(Account account,Account updatedAccount){
        accounts.set(accounts.indexOf(account), updatedAccount);
    }
    public void deleteAccount(Account account){
        accounts.remove(account);
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void updateGenre(Genre genre, Genre updatedGenre) {
        genres.set(genres.indexOf(genre), updatedGenre);
    }

    public void deleteGenre(Genre genre) {
        genres.remove(genre);
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void updateArtist(Artist artist, Artist updatedArtist) {
        artists.set(artists.indexOf(artist), updatedArtist);
    }

    public void deleteArtist(Artist artist) {
        artists.remove(artist);
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

    public void addPlayList(PlayList playlist) {
        playlists.add(playlist);
    }

    public void updatePlayList(PlayList playlist, PlayList updatedPlayList) {
        playlists.set(playlists.indexOf(playlist), updatedPlayList);
    }

    public void deletePlayList(PlayList playlist) {
        playlists.remove(playlist);
    }

    public void addArtistVoting(ArtistVoting artistVoting) {
        artistVotings.add(artistVoting);
    }

    public void addPublishedWorkVoting(PublishedWorkVoting publishedWorkVoting) {
        publishedWorkVotings.add(publishedWorkVoting);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void updateComment(Comment comment, Comment updatedComment) {
        comments.set(comments.indexOf(comment), updatedComment);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void updateReview(Review review, Review updatedReview) {
        reviews.set(reviews.indexOf(review), updatedReview);
    }

    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    public void addRecordLabel(RecordLabel recordLabel) {
        recordLabels.add(recordLabel);
    }

    public void updateRecordLabel(RecordLabel recordLabel, RecordLabel updatedRecordLabel) {
        recordLabels.set(recordLabels.indexOf(recordLabel), updatedRecordLabel);
    }

    public void deleteRecordLabel(RecordLabel recordLabel) {
        recordLabels.remove(recordLabel);
    }

    public void addTopList(TopList topList) {
        topLists.add(topList);
    }

    public void updateTopList(TopList topList, TopList updatedTopList) {
        topLists.set(topLists.indexOf(topList), updatedTopList);
    }

    public void deleteTopList(TopList topList) {
        topLists.remove(topList);
    }


    public void addAdvertisment(Advertisment advertisment) {
        advertisments.add(advertisment);
    }

    public void updateAdvertisment(Advertisment advertisment, Advertisment updatedAdvertisment) {
        advertisments.set(advertisments.indexOf(advertisment), updatedAdvertisment);
    }

    public void deleteAdvertisment(Advertisment advertisment) {
        advertisments.remove(advertisment);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void updateEvent(Event event, Event updatedEvent) {
        events.set(events.indexOf(event), updatedEvent);
    }

    public void deleteEvent(Event event) {
        events.remove(event);
    }

    public Account getAccountEmail(String email) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email)){
                return account;
            }
        }
        return null;
    }

    public Genre getGenreById(String id) {
        for (Genre genre : genres) {
            if (genre.getId().equals(id)) {
                return genre;
            }
        }
        return null;
    }

    public Artist getArtistById(String id) {
        for (Artist artist : artists) {
            if (artist.getId().equals(id)) {
                return artist;
            }
        }
        return null;
    }

    public PublishedWork getPublishedWorkById(String id) {
        for (PublishedWork publishedWork : publishedWorks) {
            if (publishedWork.getId().equals(id)) {
                return publishedWork;
            }
        }
        return null;
    }

    public PlayList getPlayListById(String id) {
        for (PlayList playlist : playlists) {
            if (playlist.getId().equals(id)) {
                return playlist;
            }
        }
        return null;
    }

    public ArtistVoting getArtistVotingById(String id) {
        for (ArtistVoting artistVoting : artistVotings) {
            if (artistVoting.getId().equals(id)) {
                return artistVoting;
            }
        }
        return null;
    }

    public PublishedWorkVoting getPublishedWorkVotingById(String id) {
        for (PublishedWorkVoting publishedWorkVoting : publishedWorkVotings) {
            if (publishedWorkVoting.getId().equals(id)) {
                return publishedWorkVoting;
            }
        }
        return null;
    }

    public Comment getCommentById(String id) {
        for (Comment comment : comments) {
            if (comment.getId().equals(id)) {
                return comment;
            }
        }
        return null;
    }

    public Review getReviewById(String id) {
        for (Review review : reviews) {
            if (review.getId().equals(id)) {
                return review;
            }
        }
        return null;
    }

    public RecordLabel getRecordLabelById(String id) {
        for (RecordLabel recordLabel : recordLabels) {
            if (recordLabel.getId().equals(id)) {
                return recordLabel;
            }
        }
        return null;
    }

    public TopList getTopListById(String id) {
        for (TopList topList : topLists) {
            if (topList.getId().equals(id)) {
                return topList;
            }
        }
        return null;
    }

    public Advertisment getAdvertismentById(String id) {
        for (Advertisment advertisment : advertisments) {
            if (advertisment.getId().equals(id)) {
                return advertisment;
            }
        }
        return null;
    }

    public Event getEventById(String id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }
}
