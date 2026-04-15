const apiUrl = 'http://localhost:8080/library'; // Change this to match your backend URL

document.getElementById('libraryForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const serial = document.getElementById('serial').value;
    const book = document.getElementById('book').value;
    const author = document.getElementById('author').value;
    const pages = document.getElementById('pages').value;

    const library = { serial, book, author, pages };

    // Add or Update Library
    try {
        let response;
        if (await getLibrary(serial)) {
            // Update existing library
            response = await fetch(`${apiUrl}/${serial}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(library),
            });
        } else {
            // Create new library
            response = await fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(library),
            });
        }
        if (response.ok) {
            loadLibraries();
            document.getElementById('libraryForm').reset();
        } else {
            alert('Error saving library');
        }
    } catch (error) {
        console.error('Error:', error);
    }
});

// Fetch all libraries
async function loadLibraries() {
    try {
        const response = await fetch(apiUrl);
        const libraries = await response.json();
        const libraryTableBody = document.getElementById('libraryTable').getElementsByTagName('tbody')[0];
        libraryTableBody.innerHTML = '';

        libraries.forEach((library) => {
            const row = libraryTableBody.insertRow();
            row.innerHTML = `
                <td>${library.serial}</td>
                <td>${library.book}</td>
                <td>${library.author}</td>
                <td>${library.pages}</td>
                <td>
                    <button onclick="deleteLibrary('${library.serial}')">Delete</button>
                </td>
            `;
        });
    } catch (error) {
        console.error('Error loading libraries:', error);
    }
}

// Get a single library
async function getLibrary(serial) {
    try {
        const response = await fetch(`${apiUrl}/${serial}`);
        return response.ok ? await response.json() : null;
    } catch (error) {
        console.error('Error fetching library:', error);
        return null;
    }
}

// Delete a library
async function deleteLibrary(serial) {
    try {
        const response = await fetch(`${apiUrl}/${serial}`, {
            method: 'DELETE',
        });
        if (response.ok) {
            loadLibraries();
        } else {
            alert('Error deleting library');
        }
    } catch (error) {
        console.error('Error deleting library:', error);
    }
}

// Load libraries on page load
window.onload = loadLibraries;
