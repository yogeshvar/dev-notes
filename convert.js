// Function to extract reading time from content
function estimateReadingTime(content) {
  const wordsPerMinute = 200;
  const words = content.split(/\s+/).length;
  return Math.ceil(words / wordsPerMinute);
}

// Function to extract first paragraph as excerpt
function getExcerpt(content) {
  const paragraphs = content.split('\n\n');
  // Find first non-empty paragraph that's not a link
  const excerpt = paragraphs.find(p => 
    p.trim() && !p.includes('[') && !p.includes('---')
  );
  return excerpt ? excerpt.slice(0, 150) + '...' : '';
}

// Function to parse markdown file
function parseMarkdown(filepath, content) {
  const parts = content.split('---\n');
  const filename = filepath.split('/').pop();
  
  // Handle both formats (with and without frontmatter)
  if (parts.length >= 3) {
    // Parse YAML frontmatter
    const frontmatter = parts[1].split('\n').reduce((acc, line) => {
      const [key, ...value] = line.split(':');
      if (key && value) {
        acc[key.trim()] = value.join(':').trim();
      }
      return acc;
    }, {});

    // Get main content
    const mainContent = parts.slice(2).join('---\n');
    
    // Extract categories/tags
    const categories = frontmatter.categories ? 
      frontmatter.categories.split(' ') : 
      ['uncategorized'];

    // Get category from filepath
    const category = filepath.split('/').slice(-2, -1)[0];

    return {
      filename,
      filepath,
      title: frontmatter.title?.replace(/"/g, '') || filename,
      date: frontmatter.date || 'Unknown',
      readingTime: estimateReadingTime(mainContent),
      tags: [...categories, category],
      content: mainContent.trim(),
      excerpt: getExcerpt(mainContent)
    };
  } else {
    // Handle simple markdown without frontmatter
    const category = filepath.split('/').slice(-2, -1)[0];
    return {
      filename,
      filepath,
      title: filename.replace(/\.[^/.]+$/, ''),
      date: 'Unknown',
      readingTime: estimateReadingTime(content),
      tags: ['uncategorized', category],
      content: content.trim(),
      excerpt: getExcerpt(content)
    };
  }
}

// Function to recursively get all markdown files
async function getMarkdownFiles(dir) {
  const fs = require('fs').promises;
  const path = require('path');
  const files = await fs.readdir(dir, { withFileTypes: true });
  
  const markdownFiles = await Promise.all(
    files.map(async file => {
      const fullPath = path.join(dir, file.name);
      if (file.isDirectory()) {
        return getMarkdownFiles(fullPath);
      } else if (file.name.endsWith('.md') || file.name.endsWith('.markdown')) {
        return [fullPath];
      }
      return [];
    })
  );
  
  return markdownFiles.flat();
}

// Main function to process all files
async function processMarkdownFiles() {
  const fs = require('fs').promises;
  const path = require('path');
  
  try {
    // Get all markdown files recursively
    const markdownFiles = await getMarkdownFiles('posts');
    
    // Process each file
    const posts = await Promise.all(
      markdownFiles.map(async filepath => {
        const content = await fs.readFile(filepath, 'utf8');
        return parseMarkdown(filepath, content);
      })
    );
    
    // Sort posts by date (newest first)
    posts.sort((a, b) => {
      const dateA = new Date(a.date);
      const dateB = new Date(b.date);
      return dateB - dateA;
    });
    
    // Write to posts.json
    await fs.writeFile(
      'posts.json',
      JSON.stringify({ posts }, null, 2)
    );
    
    console.log('Successfully converted all posts to posts.json');
  } catch (error) {
    console.error('Error processing files:', error);
  }
}

processMarkdownFiles(); 