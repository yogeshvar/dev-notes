class AnimalShelter:

    def __init__(self) -> None:
        self.cats, self.dogs = [], []

    def enqueue(self, animal):
        if animal == 'Cat' or 'cat' or 0:
            self.cats.append(animal)
        else:
            self.dogs.append(animal)

    def dequeue_any(self, animal='any'):
        if animal == 'any':
            if len(self.cats):
                self.dequeue_any(animal='cat')
            self.dequeue_any(animal='dog')
        elif animal == 'cat':
            if len(self.cats) == 0:
                return None
            cat = self.cats[0]
            self.cats = self.cats[1:]
            return cat
        else:
            if len(self.dogs) == 0:
                return None
            dog = self.dogs[0]
            self.dogs = self.dogs[1:]
            return dog

    def dequeue_dog(self):
        self.dequeue_any(animal='dog')

    def dequeue_cat(self):
        self.dequeue_any(animal='cat')
