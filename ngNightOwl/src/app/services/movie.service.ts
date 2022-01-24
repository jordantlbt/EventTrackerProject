import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Movie } from '../models/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseUrl = "http://localhost:8083/";
  private url = "api/movies";

  constructor(
    private http: HttpClient,
  ) { }

  index() {
    return this.http.get<Movie[]>(this.baseUrl + this.url + '?sorted=true')
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  create(movie: Movie){
    return this.http.post<Movie[]>(this.url, movie)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(movieID: number): Observable<void>{
    return this.http.delete<void>(this.baseUrl + this.url + movieID).pipe(
    catchError( (error: any)=>{
        console.log('MovieService.destory(): error deleting movie: ');
        console.log(error);
        return throwError(
          () => new Error(
            'MovieService.destory(): error deleting movie'
          )
        )
      }
    )
    );
  }

}
