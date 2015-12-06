#! /usr/bin/env python
from BeautifulSoup import BeautifulSoup
import json
import re


soup = BeautifulSoup(open("gameofthrones_pages_current.xml"))

filter_namespaces = ["0", "14"]

# namespaces = { int(i.get("key")): i.text for i in soup.findAll("namespace") }

pages = soup.findAll("page")
pages = [p for p in pages if p.ns.text in filter_namespaces]


def parse_page(page):
    text = page.text

    parsed = {"title": page.title.text}

    # SECTIONS

    section_headers = re.findall("(==([\w\s]+)==\s)", text)

    sections = {}

    next_header = "TOP"
    leftover = text
    if section_headers:
        for header in section_headers:
            split = leftover.split(header[0])

            sections[next_header] = split[0]

            next_header = header[1]
            leftover = split[1]
    else:
        sections[next_header] = leftover

    parsed["sections"] = sections

    # GET ATTRIBUTES

    attributes = {i[0].lower():i[1] for i in re.findall("\|\s*([\w]+)[\s]*\=([^\|]+)", text)}

    for key in attributes:

        value = attributes[key]

        value = re.sub("[\[\]\n\{\}]", "", value)
        value = re.split("&lt;br&gt;", value)

        value = value if len(value)>1 else value[0]

        attributes[key] = value

    parsed["attributes"] = attributes

    return parsed



def write_page(page):

    filename = re.sub("[^\w\d]", "_", page["title"])

    with open("data/" + filename + '.json', 'w+') as file:
        json.dump(page, file)


for p in pages:
    try:
        write_page(parse_page(p))
    except Exception as e:
        print e





