import { Component, OnInit } from '@angular/core';
import { Movies } from 'src/app/models/movies';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  selected: Movies | null = null;
  movies: Movies[] = [];
  newMovie: Movies = new Movies();
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

}
