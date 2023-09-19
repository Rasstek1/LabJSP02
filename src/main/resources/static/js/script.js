
//Animation pour la transition entre les pages
/*document.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', () => {
        document.querySelector('.content').classList.remove('content');

        // Une petite pause pour permettre la suppression de l'animation avant de naviguer vers la nouvelle page
        setTimeout(() => {
            window.location = link.href;
        }, 50);
    });
});
*/

/*Animation grow shrink sans le Dom chargé*/
/*document.addEventListener('DOMContentLoaded', (event) => {
    // Ajouter une classe grow à content au chargement de la page
    const content = document.querySelector('.content');
    content.classList.add('grow');

    // Animation pour la transition entre les pages
    document.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault(); // Empêcher la navigation immédiate
            content.classList.remove('grow');
            content.classList.add('shrink');

            // Une petite pause pour permettre la suppression de l'animation avant de naviguer vers la nouvelle page
            setTimeout(() => {
                window.location = link.href;
            }, 500); // Matche la durée de l'animation CSS
        });
    });
});*/

/*Animation grow shrink avec le Dom chargé*/
document.addEventListener('DOMContentLoaded', (event) => {
    const content = document.querySelector('.content');

    content.classList.add('grow');

    document.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();

            content.classList.remove('grow');
            content.classList.add('shrink');

            setTimeout(() => {
                fetch(link.href)
                    .then(response => response.text())
                    .then(html => {
                        const parser = new DOMParser();
                        const doc = parser.parseFromString(html, 'text/html');
                        const newContent = doc.querySelector('.content').innerHTML;
                        content.innerHTML = newContent;
                        content.classList.remove('shrink');
                        content.classList.add('grow');
                    })
                    .catch(err => console.warn('Something went wrong.', err));
            }, 500);
        });
    });
});
