package br.com.molina.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filme")
public class Filme implements Comparable<Filme>{
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "title")
    private String title;
//    private long year;
//    private String rated;
//    private Date released;
//    private String runtime;
//    private String genre;
//    private String director;
//    private String writer;
//    private String actors;
//    private String plot;
//    private String language;
//    private String country;
//    private String awards;
//    private String poster;
//    private String ratings;
//    private Long metascore;
//    private Float imdbRating;
//    private String imdbVotes;
//    private String imdbID;
//    private String type;
//    private Date dvd;
//    private String boxOffice;
//    private String production;
//    private String website;
//    private String response;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	@Override
	public int compareTo(Filme o) {
		if (this.id > o.getId()) {
			return -1;
		}
		if (this.id < o.getId()) {
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return id == other.id && Objects.equals(title, other.title);
	}
	
//	@Column(name = "year")
//	public long getYear() {
//		return year;
//	}
//
//	public void setYear(long year) {
//		this.year = year;
//	}
//
//	@Column(name = "rated")
//	public String getRated() {
//		return rated;
//	}
//
//	public void setRated(String rated) {
//		this.rated = rated;
//	}
//
//	@Column(name = "released")
//	public Date getReleased() {
//		return released;
//	}
//
//	public void setReleased(Date released) {
//		this.released = released;
//	}
//
//	@Column(name = "runtime")
//	public String getRuntime() {
//		return runtime;
//	}
//
//	public void setRuntime(String runtime) {
//		this.runtime = runtime;
//	}
//
//	@Column(name = "genre")
//	public String getGenre() {
//		return genre;
//	}
//
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//
//	@Column(name = "director")
//	public String getDirector() {
//		return director;
//	}
//
//	public void setDirector(String director) {
//		this.director = director;
//	}
//
//	@Column(name = "writer")
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//	@Column(name = "actors")
//	public String getActors() {
//		return actors;
//	}
//
//	public void setActors(String actors) {
//		this.actors = actors;
//	}
//
//	@Column(name = "plot")
//	public String getPlot() {
//		return plot;
//	}
//
//	public void setPlot(String plot) {
//		this.plot = plot;
//	}
//
//	@Column(name = "language")
//	public String getLanguage() {
//		return language;
//	}
//
//	public void setLanguage(String language) {
//		this.language = language;
//	}
//
//	@Column(name = "country")
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	@Column(name = "awards")
//	public String getAwards() {
//		return awards;
//	}
//
//	public void setAwards(String awards) {
//		this.awards = awards;
//	}
//
//	@Column(name = "poster")
//	public String getPoster() {
//		return poster;
//	}
//
//	public void setPoster(String poster) {
//		this.poster = poster;
//	}
//
//	@Column(name = "ratings")
//	public String getRatings() {
//		return ratings;
//	}
//
//	public void setRatings(String ratings) {
//		this.ratings = ratings;
//	}
//
//	@Column(name = "metascore")
//	public Long getMetascore() {
//		return metascore;
//	}
//
//	public void setMetascore(Long metascore) {
//		this.metascore = metascore;
//	}
//
//	@Column(name = "imdbrating")
//	public Float getImdbRating() {
//		return imdbRating;
//	}
//
//	public void setImdbRating(Float imdbRating) {
//		this.imdbRating = imdbRating;
//	}
//
//	@Column(name = "imdbvotes")
//	public String getImdbVotes() {
//		return imdbVotes;
//	}
//
//	public void setImdbVotes(String imdbVotes) {
//		this.imdbVotes = imdbVotes;
//	}
//
//	@Column(name = "imdbid")
//	public String getImdbID() {
//		return imdbID;
//	}
//
//	public void setImdbID(String imdbID) {
//		this.imdbID = imdbID;
//	}
//
//	@Column(name = "type")
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	@Column(name = "dvd")
//	public Date getDvd() {
//		return dvd;
//	}
//
//	public void setDvd(Date dvd) {
//		this.dvd = dvd;
//	}
//
//	@Column(name = "boxoffice")
//	public String getBoxOffice() {
//		return boxOffice;
//	}
//
//	public void setBoxOffice(String boxOffice) {
//		this.boxOffice = boxOffice;
//	}
//
//	@Column(name = "production")
//	public String getProduction() {
//		return production;
//	}
//
//	public void setProduction(String production) {
//		this.production = production;
//	}
//
//	@Column(name = "website")
//	public String getWebsite() {
//		return website;
//	}
//
//	public void setWebsite(String website) {
//		this.website = website;
//	}
//
//	@Column(name = "response")
//	public String getResponse() {
//		return response;
//	}
//
//	public void setResponse(String response) {
//		this.response = response;
//	}
	
//    {
//    	   "Title":"A Quiet Place Part II",
//    	   "Year":"2020",
//    	   "Rated":"PG-13",
//    	   "Released":"28 May 2021",
//    	   "Runtime":"97 min",
//    	   "Genre":"Drama, Horror, Sci-Fi",
//    	   "Director":"John Krasinski",
//    	   "Writer":"John Krasinski, Bryan Woods, Scott Beck",
//    	   "Actors":"Emily Blunt, Millicent Simmonds, Cillian Murphy",
//    	   "Plot":"Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.",
//    	   "Language":"English, American Sign ",
//    	   "Country":"United States",
//    	   "Awards":"Nominated for 1 BAFTA Film Award11 wins & 32 nominations total",
//    	   "Poster":"https://m.media-amazon.com/images/M/MV5BMTE2ODU4NDEtNmRjNS00OTk1LTg4NmMtNTAzYzVlNzJmYjgzXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg",
//    	   "Ratings":[
//    	      {
//    	         "Source":"Internet Movie Database",
//    	         "Value":"7.3/10"
//    	      },
//    	      {
//    	         "Source":"Rotten Tomatoes",
//    	         "Value":"91%"
//    	      },
//    	      {
//    	         "Source":"Metacritic",
//    	         "Value":"71/100"
//    	      }
//    	   ],
//    	   "Metascore":"71",
//    	   "imdbRating":"7.3",
//    	   "imdbVotes":"196,107",
//    	   "imdbID":"tt8332922",
//    	   "Type":"movie",
//    	   "DVD":"13 Jul 2021",
//    	   "BoxOffice":"$160,072,261",
//    	   "Production":"N/A",
//    	   "Website":"N/A",
//    	   "Response":"True"
//    	}
   
}
