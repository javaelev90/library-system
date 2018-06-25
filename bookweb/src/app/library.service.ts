import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Book} from './entities/Book';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  allBooksUrl = 'http://localhost:8080/books';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) { }

  getAllBooks() {
    return this.http.get<any>(this.allBooksUrl);
  }
  editBook(book: Book) {
    console.log('Trying to send: ' + JSON.stringify(book));
    return this.http.put(this.allBooksUrl, JSON.stringify(book),{headers: this.headers});
  }
}
