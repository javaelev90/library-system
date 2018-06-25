import {Author} from './Author';

export interface Book {

  id: number;
  title: string;
  description: string;

  authorList: Author[];
}
