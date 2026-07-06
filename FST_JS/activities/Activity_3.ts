interface Book{
     title : String;
     author : readonly String[];
     year ?: number;
}

let book : Book;
book = {title : 'max',author : ['abcd', 'bcdf']};
console.log(book.author);