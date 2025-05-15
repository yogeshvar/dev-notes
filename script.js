// Theme and Typography Controls
function toggleTheme() {
  const html = document.documentElement;
  const currentTheme = html.getAttribute('data-theme');
  const newTheme = currentTheme === 'light' ? 'dark' : 'light';
  html.setAttribute('data-theme', newTheme);
  
  // Update theme icon
  const themeIcon = document.querySelector('.theme-icon');
  themeIcon.textContent = newTheme === 'light' ? '☀️' : '🌙';
  
  // Store preference
  localStorage.setItem('theme', newTheme);
}

function adjustFontSize(direction) {
  const sizes = ['small', 'medium', 'large', 'xlarge'];
  const html = document.documentElement;
  const currentSize = html.getAttribute('data-size');
  let currentIndex = sizes.indexOf(currentSize);
  
  if (direction === 'up' && currentIndex < sizes.length - 1) {
    currentIndex++;
  } else if (direction === 'down' && currentIndex > 0) {
    currentIndex--;
  }
  
  html.setAttribute('data-size', sizes[currentIndex]);
  localStorage.setItem('fontSize', sizes[currentIndex]);
}

function adjustSpacing() {
  const spacings = ['tight', 'normal', 'loose'];
  const html = document.documentElement;
  const currentSpacing = html.getAttribute('data-spacing');
  let currentIndex = spacings.indexOf(currentSpacing);
  
  currentIndex = (currentIndex + 1) % spacings.length;
  html.setAttribute('data-spacing', spacings[currentIndex]);
  localStorage.setItem('lineSpacing', spacings[currentIndex]);
}

// Scroll Progress Tracking
function updateReadingProgress() {
  const content = document.querySelector('.content');
  const contentBox = content.getBoundingClientRect();
  const contentHeight = contentBox.height;
  const scrolled = window.scrollY;
  const windowHeight = window.innerHeight;
  const totalHeight = contentHeight - windowHeight;
  
  const progress = Math.min((scrolled / totalHeight) * 100, 100);
  const progressBar = document.querySelector('.progress-indicator');
  const progressText = document.querySelector('.progress-percentage');
  
  progressBar.style.width = `${progress}%`;
  progressText.textContent = `${Math.round(progress)}%`;
}

// Vim-style navigation
let vimBuffer = '';
let vimNumberBuffer = '';
const VIM_TIMEOUT = 1000; // Reset buffer after 1 second
const SCROLL_AMOUNT = 50; // Pixels to scroll for j/k
let searchMode = false;
let searchInput = '';

function clearVimBuffers() {
  vimBuffer = '';
  vimNumberBuffer = '';
}

function getScrollMultiplier() {
  return vimNumberBuffer ? parseInt(vimNumberBuffer) : 1;
}

function handleSearch(e) {
  if (!searchMode) return;
  
  if (e.key === 'Enter') {
    e.preventDefault();
    const searchText = searchInput.toLowerCase();
    const content = document.querySelector('.content').textContent.toLowerCase();
    const searchIndex = content.indexOf(searchText);
    
    if (searchIndex !== -1) {
      // Create a range to find the position
      const range = document.createRange();
      const textNodes = [];
      const walker = document.createTreeWalker(
        document.querySelector('.content'),
        NodeFilter.SHOW_TEXT,
        null,
        false
      );
      
      let node;
      while (node = walker.nextNode()) {
        textNodes.push(node);
      }
      
      let charCount = 0;
      let targetNode = null;
      let offset = 0;
      
      for (let node of textNodes) {
        if (charCount + node.length > searchIndex) {
          targetNode = node;
          offset = searchIndex - charCount;
          break;
        }
        charCount += node.length;
      }
      
      if (targetNode) {
        range.setStart(targetNode, offset);
        range.setEnd(targetNode, offset + searchText.length);
        
        // Scroll the range into view
        range.getBoundingClientRect().top;
        window.scrollTo({
          top: window.scrollY + range.getBoundingClientRect().top - 100,
          behavior: 'smooth'
        });
        
        // Highlight the text temporarily
        const highlight = document.createElement('span');
        highlight.style.backgroundColor = 'var(--text)';
        highlight.style.color = 'var(--bg)';
        range.surroundContents(highlight);
        
        setTimeout(() => {
          // Remove highlight after 2 seconds
          const parent = highlight.parentNode;
          while (highlight.firstChild) {
            parent.insertBefore(highlight.firstChild, highlight);
          }
          parent.removeChild(highlight);
        }, 2000);
      }
    }
    
    // Exit search mode
    searchMode = false;
    searchInput = '';
    document.querySelector('.search-overlay')?.remove();
  } else if (e.key === 'Escape') {
    searchMode = false;
    searchInput = '';
    document.querySelector('.search-overlay')?.remove();
  } else if (e.key.length === 1) {
    searchInput += e.key;
    document.querySelector('.search-input').textContent = searchInput;
  } else if (e.key === 'Backspace') {
    searchInput = searchInput.slice(0, -1);
    document.querySelector('.search-input').textContent = searchInput;
  }
}

function createSearchOverlay() {
  const overlay = document.createElement('div');
  overlay.className = 'search-overlay';
  overlay.innerHTML = `
    <div class="search-container">
      <span class="search-prefix">/</span>
      <span class="search-input"></span>
    </div>
  `;
  document.body.appendChild(overlay);
}

function handleVimNavigation(e) {
  // Handle search mode separately
  if (searchMode) {
    handleSearch(e);
    return;
  }

  // Only handle when not in input fields
  if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') {
    return;
  }

  // Handle numbers
  if (!isNaN(e.key) && e.key !== ' ') {
    vimNumberBuffer += e.key;
    return;
  }

  // Handle search activation
  if (e.key === '/' && !searchMode) {
    e.preventDefault();
    searchMode = true;
    createSearchOverlay();
    return;
  }

  vimBuffer += e.key;
  
  setTimeout(clearVimBuffers, VIM_TIMEOUT);

  const multiplier = getScrollMultiplier();

  // Handle navigation commands
  switch (vimBuffer) {
    case 'gg':
      window.scrollTo({
        top: 0,
        behavior: 'smooth'
      });
      clearVimBuffers();
      break;
    
    case 'GG':
      window.scrollTo({
        top: document.documentElement.scrollHeight,
        behavior: 'smooth'
      });
      clearVimBuffers();
      break;
    
    case 'j':
      window.scrollBy({
        top: SCROLL_AMOUNT * multiplier,
        behavior: 'smooth'
      });
      clearVimBuffers();
      break;
    
    case 'k':
      window.scrollBy({
        top: -SCROLL_AMOUNT * multiplier,
        behavior: 'smooth'
      });
      clearVimBuffers();
      break;

    case 'ff':
      showFuzzyFinder();
      clearVimBuffers();
      break;
  }
}

function handleVimControlKeys(e) {
  // Only handle when not in input fields
  if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') {
    return;
  }

  const multiplier = getScrollMultiplier();
  
  if (e.ctrlKey) {
    switch (e.key) {
      case 'd':
        e.preventDefault();
        window.scrollBy({
          top: window.innerHeight * 0.5 * multiplier,
          behavior: 'smooth'
        });
        clearVimBuffers();
        break;
      
      case 'u':
        e.preventDefault();
        window.scrollBy({
          top: -window.innerHeight * 0.5 * multiplier,
          behavior: 'smooth'
        });
        clearVimBuffers();
        break;
    }
  }
}

// View toggle functionality
function toggleView(view) {
  const blogGrid = document.querySelector('.blog-grid');
  const buttons = document.querySelectorAll('.view-control');
  
  // Update view
  blogGrid.setAttribute('data-view', view);
  
  // Update buttons
  buttons.forEach(button => {
    if (button.getAttribute('onclick').includes(view)) {
      button.classList.add('active');
    } else {
      button.classList.remove('active');
    }
  });
  
  // Store preference
  localStorage.setItem('blogView', view);
}

// Load saved preferences and initialize scroll tracking
document.addEventListener('DOMContentLoaded', () => {
  const html = document.documentElement;
  
  // Load theme preference
  const savedTheme = localStorage.getItem('theme');
  if (savedTheme) {
    html.setAttribute('data-theme', savedTheme);
    const themeIcon = document.querySelector('.theme-icon');
    themeIcon.textContent = savedTheme === 'light' ? '☀️' : '🌙';
  }
  
  // Load font size preference
  const savedFontSize = localStorage.getItem('fontSize');
  if (savedFontSize) {
    html.setAttribute('data-size', savedFontSize);
  }
  
  // Load line spacing preference
  const savedLineSpacing = localStorage.getItem('lineSpacing');
  if (savedLineSpacing) {
    html.setAttribute('data-spacing', savedLineSpacing);
  }

  // Initialize scroll progress
  updateReadingProgress();
  window.addEventListener('scroll', updateReadingProgress);
  window.addEventListener('resize', updateReadingProgress);

  // Initialize view preference
  const savedView = localStorage.getItem('blogView');
  if (savedView) {
    toggleView(savedView);
  }

  // Initialize blog
  initializeBlog();
});

// Newsletter form handling
document.addEventListener('DOMContentLoaded', () => {
  const form = document.querySelector('.newsletter form');
  if (form) {
    form.addEventListener('submit', (e) => {
      e.preventDefault();
      const email = form.querySelector('input[type="email"]').value;
      // Here you would typically send this to your backend
      console.log('Newsletter signup:', email);
      alert('Thanks for signing up! We\'ll be in touch soon.');
      form.reset();
    });
  }
});

// Add styles for search overlay
const style = document.createElement('style');
style.textContent = `
  .search-overlay {
    position: fixed;
    bottom: 2rem;
    left: 50%;
    transform: translateX(-50%);
    background: var(--bg);
    padding: 0.5rem 1rem;
    border: 1px solid var(--border);
    border-radius: 4px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    z-index: 1000;
    font-family: monospace;
    font-size: 1rem;
  }
  .search-container {
    display: flex;
    gap: 0.25rem;
  }
  .search-prefix {
    color: var(--muted);
  }
  .search-input {
    color: var(--text);
    min-width: 1ch;
  }
`;
document.head.appendChild(style);

// Update event listeners
document.addEventListener('keydown', handleVimControlKeys);
document.addEventListener('keypress', handleVimNavigation);
document.addEventListener('scroll', updateReadingProgress);
window.addEventListener('resize', updateReadingProgress);

// Markdown handling
async function loadAllPosts() {
  try {
    const response = await fetch('posts.json');
    const data = await response.json();
    return data.posts.map(post => ({
      ...post,
      content: marked.parse(post.content)
    }));
  } catch (error) {
    console.error('Error loading posts:', error);
    return [];
  }
}

function renderPost(post) {
  const postContent = document.getElementById('post-content');
  postContent.innerHTML = `
    <article>
      <div class="post-header">
        <a href="#" class="back-link">← Back to Home</a>
        <h2 class="post-title">${post.title}</h2>
        <div class="post-date">${post.date}</div>
      </div>
      ${post.content}
      <div class="post-meta">
        ${post.readingTime} min read • ${post.tags.join(', ')}
      </div>
    </article>
  `;
}

function getPostCategory(filename) {
  // All posts in the current dataset are AI posts
  // This will need to be updated when personal blog posts are added
  return 'AI';
}

function renderPostCard(post) {
  const category = getPostCategory(post.filename);
  const categoryClass = category.toLowerCase();
  
  return `
    <a href="#${encodeURIComponent(post.filepath)}" class="blog-card ${categoryClass}" onclick="loadPost('${post.filepath}')">
      <div class="card-category">${category}</div>
      <span class="card-bullet">•</span>
      <time class="card-date">${post.date}</time>
      <h3 class="card-title">${post.title}</h3>
      <p class="card-excerpt">${post.content.replace(/<[^>]*>/g, '').slice(0, 150)}...</p>
      <div class="card-meta">
        ${post.readingTime} min read • ${post.tags[0]}
        ${category === 'AI' ? '<span class="ai-badge">Written by ScholarSynth</span>' : ''}
      </div>
    </a>
  `;
}

async function loadPost(filepath) {
  const posts = await loadAllPosts();
  const post = posts.find(p => p.filepath === filepath);
  if (post) {
    // Hide home intro and show post content
    document.querySelector('.home-intro').style.display = 'none';
    document.getElementById('post-content').style.display = 'block';
    // Hide blog list and newsletter when viewing a post
    document.querySelector('.blog-list').style.display = 'none';
    document.querySelector('.newsletter').style.display = 'none';
    renderPost(post);
    window.scrollTo(0, 0);
  } else {
    // Show home intro and hide post content
    document.querySelector('.home-intro').style.display = 'block';
    document.getElementById('post-content').style.display = 'none';
    // Show blog list and newsletter on home page
    document.querySelector('.blog-list').style.display = 'block';
    document.querySelector('.newsletter').style.display = 'block';
  }
}

let currentFilter = 'all';

function filterPosts(filter) {
  currentFilter = filter;
  
  // Update active tab
  document.querySelectorAll('.tab').forEach(tab => {
    tab.classList.toggle('active', tab.getAttribute('onclick').includes(filter));
  });
  
  // Re-render posts with filter
  initializeBlog();
}

async function initializeBlog() {
  const posts = await loadAllPosts();
  const postsContainer = document.getElementById('posts-container');
  
  // Filter posts based on current filter
  const filteredPosts = posts.filter(post => {
    if (currentFilter === 'ai') {
      return true; // Currently all posts are AI posts
    }
    if (currentFilter === 'blogs') {
      return false; // No blog posts yet
    }
    return true; // Show all posts for 'all' filter
  });
  
  // Show message if no posts available
  if (filteredPosts.length === 0) {
    postsContainer.innerHTML = `
      <div class="no-posts">
        <p>No posts available${currentFilter !== 'all' ? ' in this category' : ''}.</p>
      </div>
    `;
  } else {
    // Render filtered post cards
    postsContainer.innerHTML = filteredPosts.map(renderPostCard).join('');
  }
  
  // Load post from URL hash or show home content
  const targetPost = decodeURIComponent(window.location.hash.slice(1));
  if (targetPost) {
    await loadPost(targetPost);
  } else {
    document.querySelector('.home-intro').style.display = 'block';
    document.getElementById('post-content').style.display = 'none';
  }
}

// Initialize when DOM is loaded
document.addEventListener('DOMContentLoaded', async () => {
  // Load initial state
  await initializeBlog();
  
  // Handle navigation
  const targetPost = decodeURIComponent(window.location.hash.slice(1));
  if (targetPost) {
    await loadPost(targetPost);
  }
});

// Handle navigation
window.addEventListener('hashchange', async () => {
  const targetPost = decodeURIComponent(window.location.hash.slice(1));
  if (targetPost) {
    await loadPost(targetPost);
  } else {
    // Show home page content when hash is cleared
    document.querySelector('.home-intro').style.display = 'block';
    document.getElementById('post-content').style.display = 'none';
    document.querySelector('.blog-list').style.display = 'block';
    document.querySelector('.newsletter').style.display = 'block';
  }
});

// Fuzzy Search
function fuzzyMatch(pattern, str) {
  pattern = pattern.toLowerCase();
  str = str.toLowerCase();
  
  let patternIdx = 0;
  let strIdx = 0;
  const matches = [];

  while (patternIdx < pattern.length && strIdx < str.length) {
    if (pattern[patternIdx] === str[strIdx]) {
      matches.push(strIdx);
      patternIdx++;
    }
    strIdx++;
  }

  return patternIdx === pattern.length ? matches : null;
}

function highlightMatches(text, matches) {
  if (!matches) return text;
  
  let result = '';
  let lastIdx = 0;
  
  matches.forEach(idx => {
    result += text.slice(lastIdx, idx);
    result += `<span class="highlight">${text[idx]}</span>`;
    lastIdx = idx + 1;
  });
  
  result += text.slice(lastIdx);
  return result;
}

let searchPalette = null;
let allPosts = [];

async function showFuzzyFinder() {
  if (searchPalette) return;
  
  // Create search palette
  searchPalette = document.createElement('div');
  searchPalette.className = 'search-palette';
  
  // Fix for Safari: ensure backdrop-filter works
  searchPalette.style.webkitBackdropFilter = 'blur(4px)';
  searchPalette.style.backdropFilter = 'blur(4px)';
  
  searchPalette.innerHTML = `
    <div class="search-palette-content">
      <div class="search-input-wrapper">
        <span class="search-icon">ff</span>
        <input type="text" class="search-input" placeholder="Search posts..." autofocus>
      </div>
      <div class="search-results"></div>
    </div>
  `;
  
  document.body.appendChild(searchPalette);
  const input = searchPalette.querySelector('.search-input');
  const results = searchPalette.querySelector('.search-results');
  
  // Load posts if not already loaded
  if (allPosts.length === 0) {
    allPosts = await loadAllPosts();
  }
  
  // Handle input
  input.addEventListener('input', () => {
    const query = input.value.trim();
    if (!query) {
      results.innerHTML = `
        <div class="no-results">
          Start typing to search posts...
        </div>
      `;
      return;
    }
    
    // Search through posts
    const matches = allPosts
      .map(post => {
        const titleMatch = fuzzyMatch(query, post.title);
        if (titleMatch) {
          return {
            post,
            matches: titleMatch,
            score: titleMatch.length,
            matchType: 'title'
          };
        }
        
        // Search in content if no title match
        const contentMatch = fuzzyMatch(query, post.content.replace(/<[^>]*>/g, ''));
        if (contentMatch) {
          return {
            post,
            matches: contentMatch,
            score: contentMatch.length * 0.5, // Lower score for content matches
            matchType: 'content'
          };
        }
        
        return null;
      })
      .filter(Boolean)
      .sort((a, b) => b.score - a.score)
      .slice(0, 5); // Show top 5 results
    
    if (matches.length === 0) {
      results.innerHTML = `
        <div class="no-results">
          No matching posts found
        </div>
      `;
      return;
    }
    
    results.innerHTML = matches
      .map(({ post, matches, matchType }) => `
        <a href="#${encodeURIComponent(post.filepath)}" 
           class="search-result" 
           onclick="loadPost('${encodeURIComponent(post.filepath)}'); closeFuzzyFinder();">
          <div class="result-title">
            ${matchType === 'title' 
              ? highlightMatches(post.title, matches)
              : post.title}
          </div>
          <div class="result-meta">
            ${post.date} • ${post.readingTime} min read
          </div>
        </a>
      `)
      .join('');
  });
  
  // Handle keyboard navigation
  input.addEventListener('keydown', (e) => {
    const results = searchPalette.querySelectorAll('.search-result');
    const current = searchPalette.querySelector('.search-result.selected');
    let next;
    
    switch (e.key) {
      case 'ArrowDown':
      case 'j':
        e.preventDefault();
        if (!current) {
          next = results[0];
        } else {
          const index = Array.from(results).indexOf(current);
          next = results[index + 1] || results[0];
        }
        break;
        
      case 'ArrowUp':
      case 'k':
        e.preventDefault();
        if (!current) {
          next = results[results.length - 1];
        } else {
          const index = Array.from(results).indexOf(current);
          next = results[index - 1] || results[results.length - 1];
        }
        break;
        
      case 'Enter':
        if (current) {
          e.preventDefault();
          current.click();
        }
        break;
        
      case 'Escape':
        e.preventDefault();
        closeFuzzyFinder();
        break;
    }
    
    if (next) {
      current?.classList.remove('selected');
      next.classList.add('selected');
      next.scrollIntoView({ block: 'nearest' });
    }
  });
  
  // Focus input
  input.focus();
  
  // Close on click outside
  searchPalette.addEventListener('click', (e) => {
    if (e.target === searchPalette) {
      closeFuzzyFinder();
    }
  });
}

function closeFuzzyFinder() {
  if (searchPalette) {
    searchPalette.remove();
    searchPalette = null;
  }
} 