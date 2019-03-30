# Foundation Of Backend Architecture Of Internet Application

## Task 1: SJTU official home page analysis

### Advantage

- A lot of information in one page
- Quick rendering
- No error in console
- Resposive and animated page

### Disadvantages

- Using plain html and css in building webpage
- Using relatively old and unpopular Jquery styling
- Relatively slow page rendering compared to other popular webpages(eg: google.com, facebook.com ...)
- JavaScript in html files are not compressed and not taken care well so might take more resources to load(comments are dangling and not deleted in source script files)

### Suggestion and Optimization

- Use popular framework such as Vue, React to reduce workload
- Use online compressor to style HTML, script files to reduce load
- Reduce number of elements or components(especially images) in a single page to reduce page rendering time. Use plain color instead
