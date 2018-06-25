import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Book} from '../entities/Book';
import {LibraryService} from '../library.service';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit, OnDestroy {

  @Input() book: Book;
  onDestroy$ = new Subject<boolean>();
  constructor(private libraryService: LibraryService) { }

  ngOnInit() {
  }

  ngOnDestroy(): void {
    this.onDestroy$.next();
  }

  update() {
    this.libraryService.editBook(this.book).pipe(takeUntil(this.onDestroy$)).subscribe(data => {
      if (data != null) { console.log(data); } }, error => console.log(error));
  }

}
