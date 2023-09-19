
//Animation pour la transition entre les pages
document.querySelectorAll('a').forEach(link => {
    link.addEventListener('click', () => {
        document.querySelector('.content').classList.remove('content');

        // Une petite pause pour permettre la suppression de l'animation avant de naviguer vers la nouvelle page
        setTimeout(() => {
            window.location = link.href;
        }, 50);
    });
});

