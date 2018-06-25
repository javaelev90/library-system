import {Component, OnDestroy, OnInit} from '@angular/core';
import {Book} from '../entities/Book';
import {LibraryService} from '../library.service';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit, OnDestroy {

  books: Book[];
  onDestroy$ = new Subject<boolean>();
  constructor(private libraryService: LibraryService) { }

  ngOnInit() {
    this.libraryService.getAllBooks().pipe(takeUntil(this.onDestroy$))
      .subscribe(data => this.books = data,
        error => console.log(error));
  }

  ngOnDestroy(): void {
    this.onDestroy$.next();
  }

}
