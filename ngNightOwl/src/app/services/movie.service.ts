import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Movies } from '../models/movies';

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
    return this.http.get<Movies[]>(this.baseUrl + this.url + '?sorted=true')
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  create(movie: Movies){
    return this.http.post<Movies[]>(this.url, movie)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }
}
