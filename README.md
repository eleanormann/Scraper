# Simple Review Scraper

### Back story

I needed to buy new running shoes. I found a website 
with a comprehensive set of reviews of different shoes, 
but the gui was awkward and annoying (not least the full
screen overlay periodically trying to get me to sign up to the 
newsletter). Stuff this, I thought. I'll scrape the 
info I need. 


### This is a tech exercise

This is a quick and dirty scraper I wrote 
for one specific task. Your job is to refactor/rework 
it into a generic scraper implemented according to 
good coding practices. Its up to you how generic you
make it but it should at least be able to scrape reviews
on a different review site. 

### Current usage notes

I just ran it directly from the ide. Edit the 
``dom-attributes.json`` file in the test resources
directory then run ``ScrapingRunner``. It writes 
to ``reviews-summary.csv`` and can be opened in 
your favourite spreadsheet.
