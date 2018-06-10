var express = require('express');
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert'); 
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  var data = {
    "slingId": req.query.slingId,
    "measuredDiameter": req.query.measuredDiameter,
    "kinks": req.query.kinks,
    "crushed": req.query.crushed,
    "birdcage1Lay": req.query.birdcage1Lay,
    "birdcage1Strand": req.query.birdcage1Strand,
    "brokenWire": req.query.brokenWire,
    "heatDamage": req.query.heatDamage,
    "endAttachmentFitting": req.query.endAttachmentFitting,
    "endAttachmentBrokenWires": req.query.endAttachmentBrokenWires,
    "hookCondition": req.query.hookCondition,
    "slingIsServiceable": req.query.slingIsServiceable,
    "slingIsRejected": req.query.slingIsRejected,
    "comments": req.query.comments
  };
  console.log(data);
  const url = "mongodb://user:password1@ds229458.mlab.com:29458/wireinspection";
  MongoClient.connect(url, function (err, client) {
    assert.equal(null, err);
    const db = client.db("wireinspection");
    const col = db.collection('data');
    col.insert(data);
    console.log("Inserted Data Successfully");
    
  });
});

module.exports = router;
