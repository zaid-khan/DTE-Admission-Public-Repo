#!/usr/bin/python3

import ssl
import pandas as pd
from tkinter import *
fields = 'Link', 'Table ID', 'File Name'

def fetch(entries):
   i = 0
   for entry in entries:

      if i == 0:
        linktext  = entry[1].get()
      elif i == 1:
        tableidtext = entry[1].get()
      else:
        filename = entry[1].get()
      i = i + 1

   ssl._create_default_https_context = ssl._create_unverified_context
   tables = pd.read_html(linktext)

   print(tables[int(tableidtext)])
   tables[int(tableidtext)].to_csv("/home/zaid/Desktop/"+ filename + ".csv", index=False)

   print('"%s"' % (linktext))
   print('"%s"' % (tableidtext))


def makeform(root, fields):
   entries = []
   for field in fields:
      row = Frame(root)
      lab = Label(row, width=15, text=field, anchor='w')
      ent = Entry(row)
      row.pack(side=TOP, fill=X, padx=5, pady=5)
      lab.pack(side=LEFT)
      ent.pack(side=RIGHT, expand=YES, fill=X)
      entries.append((field, ent))
   return entries

if __name__ == '__main__':
   root = Tk()
   root.title("Web Crawler")
   ents = makeform(root, fields)
   root.bind('<Return>', (lambda event, e=ents: fetch(e)))
   b1 = Button(root, text='Save As CSV',
          command=(lambda e=ents: fetch(e)))
   b1.pack(side=LEFT, padx=5, pady=5)
   b2 = Button(root, text='Quit', command=root.quit)
   b2.pack(side=LEFT, padx=5, pady=5)
   root.mainloop()
