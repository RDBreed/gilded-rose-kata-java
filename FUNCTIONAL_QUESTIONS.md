The assignment gives some uncertanities about the existing functional behaviour, which I would like to address here
 (in a real-life situation, I would like to discuss this cases with the team and business/PO to ensure we have the
  same ideas about this):
- What should happen when an item is added with a quality higher that 50, not being a sulfaras?
    - Throw an exception?
    - Make the value 50?
    - Ignore the value as is?
    
- When a sulfaras has a initial value lower than 80, should this be valid, as the sentence states "Just for
 clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a legendary item and as
  such its Quality is 80 and it never alters.". I was unsure if this meant that quality would not go beside 80 or it
   could _only_ be 80...
   
- What about naming? In the requirements, there is just "Aged Brie" or "Sulfaras" or "Backstage passes", but the actual
 code is not
 ignoring cases and also has an explicit value for those items (namely: "Aged Brie", "Sulfuras, Hand of Ragnaros" and
  "Backstage passes to a TAFKAL80ETC concert"). For the new "Conjured" functionality, the same question raises
  ; should an item be specifically named "Conjured" or is "Conjured Mana Cake" also valid?