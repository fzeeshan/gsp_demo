﻿using System.Collections.Generic;

namespace gudusoft.gsqlparser.demos.dlineage.model.ddl.schema
{
    using System.Xml.Serialization;

    public class index
	{

        [XmlAttribute]
        public string name { get; set; }

        [XmlElement("index-column")]
        public indexColumn[] indexColumns { get; set; }
	}

}