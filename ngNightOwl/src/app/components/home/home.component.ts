import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  selected: Movie | null = null;
  movies: Movie[] = [];
  newMovie: Movie = new Movie();
  category = [
    'all',
    'comedy',
    'childrens',
    'horror',
    'thriller',
    'western',
    'romance',
    'fantasy',
    'action',
    'drama',
    'musical'
  ]
  selectedCategory = 'all';

  constructor(
    private movieService: MovieService,
  ) { }

  ngOnInit(): void {

    this.loadMovies();
  }

  loadMovies(){
    this.movieService.index().subscribe(
      movies => {this.movies = movies},
      err => console.error('observer got an error: ' + err)
    );
   }

   createMovie(movie: Movie){
    this.movieService.create(movie).subscribe(
     movies => {
       this.loadMovies();
       this.newMovie = new Movie();
     },
     err => console.error('observer got an error: ' + err)
    );
  }

  deleteMovie(id: number){
    this.movieService.destroy(id).subscribe({
      next: () =>{
        this.loadMovies();
      },
      error: (fail)=> {
        console.error("HomeComponent.deleteTodo: error delteing movie");
      console.error(fail);

      }
    })
    };

}
