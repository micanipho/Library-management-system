const API_BASE_URL = '/lms/api/v1'; // Replace with your actual API base URL

document.getElementById('get-all-books').addEventListener('click', () => {
    fetch(`${API_BASE_URL}/books`)
        .then(response => response.json())
        .then(data => {
            const booksContainer = document.getElementById('books-container');
            booksContainer.innerHTML = '';
            data.forEach(book => {
                booksContainer.innerHTML += `<p>${book.title} by ${book.author} (ID: ${book.id})</p>`;
            });
        });
});

document.getElementById('search-books').addEventListener('click', () => {
    const searchTerm = document.getElementById('search-input').value;
    fetch(`${API_BASE_URL}/books/search?title=${searchTerm}&author=${searchTerm}`)
        .then(response => response.json())
        .then(data => {
            const searchResults = document.getElementById('search-results');
            searchResults.innerHTML = '';
            data.forEach(book => {
                searchResults.innerHTML += `<p>${book.title} by ${book.author} (ID: ${book.id})</p>`;
            });
        });
});

document.getElementById('add-book').addEventListener('click', () => {
    const title = document.getElementById('add-title').value;
    const author = document.getElementById('add-author').value;
    fetch(`${API_BASE_URL}/books`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, author })
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('add-result').textContent = `Book added: ${data.title}`;
        });
});

document.getElementById('borrow-book').addEventListener('click', () => {
    const bookId = document.getElementById('borrow-book-id').value;
    fetch(`${API_BASE_URL}/books/borrow`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ bookId })
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('borrow-result').textContent = `Book ${data.bookId} borrowed`;
        });
});

document.getElementById('return-book').addEventListener('click', () => {
    const bookId = document.getElementById('return-book-id').value;
    fetch(`${API_BASE_URL}/books/return`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ bookId })
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('return-result').textContent = `Book ${data.bookId} returned`;
        });
});