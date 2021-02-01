package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Map.Entry;
import static java.util.stream.Collectors.*;

import java.util.AbstractMap;


import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;

public class denemeStaticClass {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Album> albums = new ArrayList<Album>();
		
		List<Artist> artists = new ArrayList<Artist>();
		
		
		artists.add(new Artist("bob"));
		artists.add(new Artist("tom"));
		
		List<Artist> artists2 = new ArrayList<Artist>();
		
		artists2.add(new Artist("bill"));
		
		Album album1 = new Album(artists);
		Album album2 = new Album(artists2);
		
		albums.add(album1);
		albums.add(album2);
		
		//1 album 1 den cok artist e sahip
		/*
		Map<Artist, List<Album>> artistAlbumMap =  (Map<Artist, List<Album>>)
				albums
				.stream()
				.flatMap(album -> album.getArtists().stream().map(artist-> new AbstractMap.SimpleEntry(artist ,album)))
				.collect(groupingBy(Entry::getKey ,mapping( e -> e. Entry::getValue,Collectors.toList())));
		
		
		
		 
		 	Map<String ,List<OneStudentCourses>> x = ( Map <String, List<OneStudentCourses>>) manyStudentCoursesList
													.stream()
													.flatMap(item -> item.getSubjects().stream().map(subject -> new AbstractMap.SimpleEntry(subject, item)  ))
													   .collect(Collectors.groupingBy(e -> ((SimpleEntry<String, OneStudentCourses>) e).getKey(), Collectors
										                        .mapping(e -> ((SimpleEntry<String, OneStudentCourses>) e).getValue(), Collectors.toList())));

		 */
	}
	
	static class Artist{
		private final String name;
		
		public Artist(String name) {
			this.name = name;
		}
		public String toString() {
			return name;
		}
	}
	static class Album{
		List<Artist> artists;
		
		public Album(List<Artist> artists) {
			this.artists = artists;
		}
		
		List<Artist> getArtists(){
			return artists;
		}
	}

}
